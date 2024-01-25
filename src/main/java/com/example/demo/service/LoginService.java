package com.example.demo.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.UserInfo;
import com.example.demo.repository.UserInfoRepository;

import lombok.RequiredArgsConstructor;

/**
 * ログイン画面 service
 * 
 */

@Service
/**
 * チェック処理やDBアクセス(Repositoryクラスの呼び出し)
 * などのビジネスロジックを実装
 */
@RequiredArgsConstructor
//lombokの提供するアノテーション。private finalで宣言したインスタンスに対して、newしたものを注入するコンストラクタを実装してくれる
public class LoginService {
	
	
	/**ユーザー情報テーブルDAO*/
	private final UserInfoRepository repository;
	
	/**
	 * ユーザー情報テーブル　主キー検索
	 * 
	 * @param loginId
	 * @return ユーザー情報テーブルを主キー検索した結果(1件)
	 */
	public Optional<UserInfo>searchUserById(String loginId){
		return repository.findById(loginId);
	}

}
