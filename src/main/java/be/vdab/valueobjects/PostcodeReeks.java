package be.vdab.valueobjects;

import javax.validation.constraints.NotNull;

import be.vdab.constraints.Postcode;
import be.vdab.constraints.PostcodeReeksVanKleinerDanOfGelijkAanTot;

@PostcodeReeksVanKleinerDanOfGelijkAanTot
public class PostcodeReeks {

	@NotNull @Postcode
	private Integer vanpostcode;
	@NotNull @Postcode
	private Integer totpostcode;
		
	public Integer getVanpostcode() {
		return vanpostcode;
	}

	public Integer getTotpostcode() {
		return totpostcode;
	}

	public boolean bevat(int postcode) {
		return postcode >= vanpostcode && postcode <= totpostcode;
	}

}
