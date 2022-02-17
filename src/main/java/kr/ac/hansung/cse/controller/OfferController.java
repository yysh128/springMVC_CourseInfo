package kr.ac.hansung.cse.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.hansung.cse.model.Offer;
import kr.ac.hansung.cse.service.OfferService;

@Controller
public class OfferController {

	@Autowired
	private OfferService offerService;
	

	@RequestMapping("/offers")
	public String showOffers(Model model) {

		List<Offer> offers = offerService.getCredits();
		model.addAttribute("offers", offers);
		
		int totalCredits = offerService.getTotalCredits();
		model.addAttribute("totalCredits", totalCredits);

		return "offers";
	}

	@RequestMapping("/createoffer") //수강 신청
	public String createOffer(Model model) {

		model.addAttribute("offer", new Offer());

		return "createoffer";
	}

	@RequestMapping(value="/doCreate", produces = "text/plain;charset=UTF-8") 
	public String doCreate(Model model, @Valid Offer offer, BindingResult result) {
		
		if(result.hasErrors()) {
			
			System.out.println("===Form data does not validated===");
			List<ObjectError> errors = result.getAllErrors();
			
			for(ObjectError error: errors) {
				System.out.println(error.getDefaultMessage());
			}
			return "createoffer";
		}
		
		offerService.insert(offer);

		return "offercreated";
	}
	
	@RequestMapping("/offerlookup")	// 수강 신청 내역 조회
	public String offerLookup(Model model) {
		
		List<Offer> offers = offerService.getOffer(2022, 1);
		model.addAttribute("offers", offers);
		
		return "offerlookup";
	}
	
	@RequestMapping("/link/{semesterInfo}")
	public String showDetails(@PathVariable String semesterInfo, Model model) {
		int year = Integer.parseInt(semesterInfo.split("-")[0]);
		int semester = Integer.parseInt(semesterInfo.split("-")[1]);
		
		List<Offer> offers = offerService.getOffer(year, semester);
		model.addAttribute("offers", offers);
		
		return semesterInfo;
	}

}
