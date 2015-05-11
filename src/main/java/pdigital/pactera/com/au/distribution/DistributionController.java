package pdigital.pactera.com.au.distribution;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DistributionController {

	@RequestMapping(value = "/distribution/ios/PacteraPulse.ipa", method = RequestMethod.GET)
	public String welcome() {
		return "home/welcome";
	}
}
