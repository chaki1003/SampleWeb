package com.example.demo.form;

import lombok.Data;

/**
 * ログイン画面 form
 * Formクラスとは
 * htmlとController間でデータの受け渡しをするためのクラス。
 * 無くてもデータの受け渡しはできるが、オブジェクトのフィールととし
 * て値を保管できるのと、入力チェックなども実装できるため便利
 */

@Data   //getter setterの役割
public class LoginForm {
	
	/**ログインID*/
	private String loginId;
	
	/**パスワード*/
	private String password;
}
