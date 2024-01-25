package com.example.demo.service;

import java.util.Optional;

import org.dozer.Mapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.entity.UserInfo;
import com.example.demo.form.SignupForm;
import com.example.demo.repository.UserInfoRepository;

import lombok.RequiredArgsConstructor;

/**
 * ログイン画面 service
 * 
 */

@Service
@RequiredArgsConstructor
public class SignupService {
	
	
	/**ユーザー情報テーブルDAO*/
	private final UserInfoRepository repository;
	
	/** Dozer mapper */
	private final Mapper mapper;
	
	/** PasswordEncoder */
	private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	/**
	 * ユーザー情報テーブル　主キー検索
	 * 
	 * @param loginId
	 * @return 登録情報Entity、すでに同じユーザIDで登録がある場合はEmpty
	 */
	public Optional<UserInfo> resistUserInfo(SignupForm form){
		//var mapper = new DozerBeanMapper();
		var userInfoExistedOpt = repository.findById(form.getLoginId());
		if(userInfoExistedOpt.isPresent()) {
			return Optional.empty();
		}
		
		var userInfo = mapper.map(form, UserInfo.class);
		var encodedPassword = passwordEncoder.encode(form.getPassword());
		userInfo.setPassword(encodedPassword);
		
		return Optional.of(repository.save(userInfo));
		//テーブルに登録したい情報をEntityに保管して(setter)、Repositoryクラスに渡すイメージ
		/**
		 * 既に登録されている場合
		 * →resistUserInfo()の戻り値は「Optional.isEnpty() == true」となる
		 * まだ登録されていない場合
		 * →resistUserInfo()の戻り値は「Optional.isEnpty() == false」となる
		 */
	}

}
