package com.cloud.porforio.commons.util;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.FileCopyUtils;

public class UploadFileUtils {

	private static final Logger logger = LoggerFactory.getLogger(UploadFileUtils.class);
	
	//파일 업로드 처리
	public static String uploadFile(String uploadPath, String originalName, byte[] fileData) throws IOException {
		//중복된 이름의 파일을 저장하지 않기 위해 UUID 키값 생성
		UUID uuid = UUID.randomUUID();
		
		//실제 저장할 파일명 = UUID + _ + 원본파일명
		String savedName = uuid.toString() + "_" + originalName;
		
		//날짜 경로 = 년 + 월 + 일
		String savedPath = calcPath(uploadPath);
		
		//파일 객체 생성 = 기본 저장경로 + 날짜경로 + UUID_파일명
		File target = new File(uploadPath + savedPath, savedName);
		
		//fileData를 파일객체에 복사
		FileCopyUtils.copy(fileData, target);
		
		return savedName;
	}

	// 1. 날짜별 경로 추출
	private static String calcPath(String uploadPath) {
		Calendar calender = Calendar.getInstance();
		
		//년
		String yearPath = File.separator + calender.get(Calendar.YEAR);
		
		//년 + 월
		String monthPath = yearPath + File.separator + new DecimalFormat("00").format(calender.get(Calendar.MONTH) + 1);
		
		//년 + 월 + 일
		String datePath = monthPath + File.separator + new DecimalFormat("00").format(calender.get(Calendar.DATE));
		
		makeDir(uploadPath, yearPath, monthPath, datePath);
		
		return datePath;
	}

	// 2. 파일 저장 기본 경로 + 날짜 경로 생성
	private static void makeDir(String uploadPath, String... paths) {
		// 기본 경로 + 날짜 경로가 이미 존재 : 메서드 종료
		if(new File(uploadPath + paths[paths.length - 1]).exists()) {
			return;
		}
		
		// 날짜 경로가 존재 X : 경로 생성을 위한 반복문 수행
		for(String path : paths) {
			//기본 경로 + 날짜 경로에 해당하는 파일 객체 생성
			File dirPath = new File(uploadPath + path);
			
			//파일 객체에 해당하는 경로가 존재 X
			if(!dirPath.exists()) {
				//경로 생성
				dirPath.mkdir();
			}
		}
	}x
	
	
}


