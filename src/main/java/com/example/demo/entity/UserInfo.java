package com.example.demo.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * ユーザ情報テーブル entity
 * 
 */


@Entity
@Table(name = "user_info") //どのテーブルとリンクしている
@Data
public class UserInfo {
	
	/**ログインID*/
	
	@Id //プライマリキー
	@Column(name = "login_id") //フィールド名と紐づける
	private String loginId;
	
	/**パスワード*/
	private String password;

}
