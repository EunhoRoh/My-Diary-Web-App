package com.mycom.myapp.user;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAO {
	//SqlSessionTemplate: MyBatis의 SqlSession을 대체하는 클래스로, 데이터베이스 쿼리를 실행하는 데 사용됩니다.
	@Autowired
	SqlSessionTemplate sqlSession;

	// 사용자 정보 조회 기능을 구현한 메소드
	public UserVO getUser(UserVO vo) {
		// sqlSession을 사용하여 "User.getUser" 쿼리를 실행하여 사용자 정보를 조회하고 결과를 반환합니다.
		return sqlSession.selectOne("User.getUser", vo);
	}
}