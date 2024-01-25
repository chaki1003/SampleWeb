package com.example.demo.controller;

import org.springframework.context.MessageSource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.constant.MessageConst;
import com.example.demo.form.LoginForm;
import com.example.demo.service.LoginService;
import com.example.demo.util.AppUtil;

import lombok.RequiredArgsConstructor;

/**
 * ログイン画面 Controller
 * 
 * @author chaki
 */

@Controller
/**
 * 画面の入力値を受け取る
 * Serviceクラスを呼び出す
 * 遷移先の画面を呼び出す
 */
@RequiredArgsConstructor
public class LoginController {


	/**ログイン画面 service*/
	private final LoginService service;
	
	/** PasswordEncoder */
	private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	/** メッセージソース */
	private final MessageSource messageSource;
	
	/**
	 * 初期表示
	 * 
	 * @param model モデル
	 * @param form 入力情報
	 * @return 表示画面
	 */

	@GetMapping("/login")
	public String view(Model model, LoginForm form) {
		/**
		 * 引数を二つ用意する
		ModelクラスとはControllerからhtmlへデータを受け渡すためのクラス(機能)
		基本的にはkeyとvalueのセットでデータを受け渡し
		画面側ではkeyからvalueを取得する
		springaではこのような書き方をすると勝手にmodelの中にformを入れて画面射返してくれる
		 */
		return "login";
		
	}
	
	/**
	 * 初期表示
	 * 
	 * @param model モデル
	 * @param form 入力情報
	 * @return 表示画面
	 */

	@PostMapping("/login")
	public String login(Model model, LoginForm form) {
		var userInfo =service.searchUserById(form.getLoginId());
//		var encordedPassword = passwordEncoder.encode(form.getPassword());
		//ハッシュ化されたパスを拾うためのデバックのコード
		var isCorrectUserAuth = userInfo.isPresent() //何らかの情報
				&& passwordEncoder.matches(form.getPassword(), userInfo.get().getPassword());
		//var ローカル変数の宣言時、変数の型を指定する代わりに「var」と書くことで、
		//型の指定を省略することができます。いわゆる型推論です。
		//isCorrectUserAuth boolean型の変数で、ユーザIDまたはパスが間違っていた場合falseとなる
		//matches 二つ引数があり、一つ目が生のパス(入力された)、二つ目がデータベースに登録されたパス
		if(isCorrectUserAuth) {
			return "redirect:/menu";
		}else {
			var errorMsg = AppUtil.getMessage(messageSource, MessageConst.LOGIN_WRONG_INPUT);
			model.addAttribute("errorMsg", errorMsg);
			return "login";
		}
	}

}
