package kr.co.gudi.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorControllerImpl implements ErrorController {
	
	@RequestMapping(value="/error")
	public String error(Model model, HttpServletRequest req) {
		
		int code = (int)req.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
		model.addAttribute("code", code);
		
		String msg = "알수없는 오류가 발생했습니다.";
		switch(code) {
			case 400:
				msg = "입력값 갯수를 확인해 주세요";
				break;
			case 403:
				msg = "권한이 없습니다.";
				break;
			case 404:
				msg = "요청 페이지가 없습니다.";
				break;
			case 405:
				msg = "전송방식(method)가 맞지 않습니다.";
				break;
			case 500:
				msg="서버처리 중 문제가 발생했습니다.";
				break;
		}
		
		model.addAttribute("msg", msg);
		
		return "error";
	}

}
