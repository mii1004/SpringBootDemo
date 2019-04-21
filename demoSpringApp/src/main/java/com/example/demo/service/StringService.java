package com.example.demo.service;

public interface StringService {

	/**
	 * 引数に指定した文字列2つを比較する
	 *
	 * @param param1 比較文字列１
	 * @param param2 比較文字列２
	 * @return 1:param1の方が大きい 0:文字列が一致 -1:param2の方が大きい -2:パラメータエラー
	 */
	public int stringCompareTo (String param1, String param2) ;

}
