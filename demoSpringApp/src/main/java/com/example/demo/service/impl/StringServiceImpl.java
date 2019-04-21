package com.example.demo.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.demo.service.StringService;

@Service
public class StringServiceImpl implements StringService {

	@Override
	public int stringCompareTo(String param1, String param2) {
		/** ロガー */
		final Logger log = LoggerFactory.getLogger(StringServiceImpl.class);

		if(param1.isEmpty() || param2.isEmpty()) {
			log.debug("パラメータエラー return -2");
			return -2;
		}

		// StringをChar配列に変換
		char[] param1CharArray = param1.toCharArray();
		char[] param2CharArray = param2.toCharArray();
		log.debug(String.format("param1: %s, param2:%s", param1, param2));

		// 文字列をループで比較するため、短い方の文字列の文字数を取得
		int shorterStringLength;
		if(param1CharArray.length == param2CharArray.length) {
			shorterStringLength = param1CharArray.length;
		} else if(param1CharArray.length > param2CharArray.length) {
			shorterStringLength = param2CharArray.length;
		} else {
			shorterStringLength = param1CharArray.length;
		}

		// 文字列を前方から比較する
		for (int i = 0; i < shorterStringLength; i++) {
			if (param1CharArray[i] > param2CharArray[i]) {
				log.debug("return 1");
				return 1;
			} else if (param1CharArray[i] < param2CharArray[i]) {
				log.debug("return -1");
				return -1;
			} else {
				continue;
			}
		}

		// 文字数が一致する場合は文字列一致(0)を返却
		if (param1CharArray.length == param2CharArray.length) {
			log.debug("return 0");
			return 0;
		} else if(param1CharArray.length > param2CharArray.length) {
			// param1の文字数が多い場合にはparam1の方が大きい(1)を返却
			log.debug("return 1");
			return 1;
		} else {
			// param2の文字数が多い場合にはparam2の方が大きい(-1)を返却
			log.debug("return -1");
			return -1;
		}
	}
}
