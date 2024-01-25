package com.example.demo.config;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
/**
 * @Configurationとセットで@Beanを付与したメソッドはDIコンテナに登録されDI注入することができる。
 * (@RequiredArgsConstructor配下でprivate finalしてインスタンス化)
 */
public class BeanDifine {
	
//	@Bean
//	PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
	
	@Bean
	Mapper mapper() {
		return new DozerBeanMapper();
	}

}
