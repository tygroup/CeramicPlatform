package com.cpf.beans.system;

import java.util.Date;

public class Useramount {
    
    private String userid;
    private String amountid;
    private Double balance;
    private Double availablebalance;
    private Double margin;
    private String ismargin;
    private Double kymargin;
    private String userlevel;
    private Date userendtime;
   
    public String getUserid() {
        return userid;
    }
 
    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

     
    public String getAmountid() {
        return amountid;
    }

     
    public void setAmountid(String amountid) {
        this.amountid = amountid == null ? null : amountid.trim();
    }
 
    public Double getBalance() {
        return balance;
    }
 
    public void setBalance(Double balance) {
        this.balance = balance;
    }

     
    public Double getAvailablebalance() {
        return availablebalance;
    }

    
    public void setAvailablebalance(Double availablebalance) {
        this.availablebalance = availablebalance;
    }

   
    public Double getMargin() {
        return margin;
    }

   
    public void setMargin(Double margin) {
        this.margin = margin;
    }
 
    public String getIsmargin() {
        return ismargin;
    }
 
    public void setIsmargin(String ismargin) {
        this.ismargin = ismargin == null ? null : ismargin.trim();
    }
 
    public Double getKymargin() {
        return kymargin;
    }

  
    public void setKymargin(Double kymargin) {
        this.kymargin = kymargin;
    }
 
	public String getUserlevel() {
		return userlevel;
	}

	public void setUserlevel(String userlevel) {
		this.userlevel = userlevel;
	}

	public Date getUserendtime() {
		return userendtime;
	}

	public void setUserendtime(Date userendtime) {
		this.userendtime = userendtime;
	}
}