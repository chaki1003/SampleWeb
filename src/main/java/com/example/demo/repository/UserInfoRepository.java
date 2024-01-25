package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.UserInfo;

/**
 * ユーザー情報テーブルDAO
 * 
 */
@Repository
//DBアクセスを行う
public interface UserInfoRepository extends JpaRepository<UserInfo,String>{ 
	//Stringはentityクラスの一つ目の型に合わせる(プライマリキー)

}
