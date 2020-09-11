function consider () {

	var result = 0;
	var dollar_to_rub = document.getElementById("dol").value;
	var euro_to_rub = document.getElementById("eur").value;

	var value = document.getElementById("value").value;
	var sel_one = document.getElementById("select_one");
	var sel_two = document.getElementById("select_two");

	var dol = sel_one[0];
	var eor = sel_one[1];
	var rub = sel_one[2];

	var dol_2 = sel_two[0];
	var eor_2 = sel_two[1];
	var rub_2 = sel_two[2];

	if (dol.selected === true){
		if (dol_2.selected === true)
			result = value;
		else if (eor_2.selected === true )
			result = value * (euro_to_rub / dollar_to_rub);
		else if (rub_2.selected === true )
			result = value * dollar_to_rub;

	}
	else if (eor.selected === true){
		if (eor_2.selected === true)
			result = value;
		else if (dol_2.selected === true )
			result = value * (dollar_to_rub / euro_to_rub);
		else if (rub_2.selected === true )
			result = value * euro_to_rub;

	}

	else if (rub.selected === true){
		if (rub_2.selected === true)
			result = value;
		else if (dol_2.selected === true )
			result = value * dollar_to_rub;
		else if (eor_2.selected === true )
			result = value * euro_to_rub;
	}

	var res = document.getElementById("result");

	res.value = Math.floor(result * 100) /100;
}