package com.cpf.beans.system;

import java.util.Date;
import java.util.List;

import com.cpf.beans.transaction.TraProduct;

public class Userinfo {
    
    private String userid;
    private String userinfoid;
    private String storename;
    private String photourl;
    private String realname;
    private String introductions;
    private String sex;
    private Date birthday;
    private String cityid;
    private String address;
    private String graduatedschool;
    private String email;
    private String webaddr;
    private String position;
    private String exhibition;
    private String awards;
    private String publishing;
    private String cypublished;
    private String verified;
    private String agencycertification;
    private String creditlevel;
    private String isBest;
    private List<TraProduct> productions;
    private Date createtime;
    private String usertype;
    private String sc;
    private String ppc;
    private String cjc;
    
    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getUserinfoid() {
        return userinfoid;
    }
    public void setUserinfoid(String userinfoid) {
        this.userinfoid = userinfoid == null ? null : userinfoid.trim();
    }

    public String getStorename() {
        return storename;
    }

    public void setStorename(String storename) {
        this.storename = storename == null ? null : storename.trim();
    }

    public String getPhotourl() {
        return photourl;
    }

    public void setPhotourl(String photourl) {
        this.photourl = photourl == null ? null : photourl.trim();
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname == null ? null : realname.trim();
    }

    public String getIntroductions() {
        return introductions;
    }

    public void setIntroductions(String introductions) {
        this.introductions = introductions == null ? null : introductions.trim();
    }

    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

   
    public String getCityid() {
        return cityid;
    }

    public void setCityid(String cityid) {
        this.cityid = cityid == null ? null : cityid.trim();
    }

   
    public String getAddress() {
        return address;
    }

   
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getGraduatedschool() {
        return graduatedschool;
    }

    
    public void setGraduatedschool(String graduatedschool) {
        this.graduatedschool = graduatedschool == null ? null : graduatedschool.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    
    public String getWebaddr() {
        return webaddr;
    }

    public void setWebaddr(String webaddr) {
        this.webaddr = webaddr == null ? null : webaddr.trim();
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
    }

   
    public String getExhibition() {
        return exhibition;
    }

    public void setExhibition(String exhibition) {
        this.exhibition = exhibition == null ? null : exhibition.trim();
    }

   
    public String getAwards() {
        return awards;
    }

    
    public void setAwards(String awards) {
        this.awards = awards == null ? null : awards.trim();
    }

    public String getPublishing() {
        return publishing;
    }

    public void setPublishing(String publishing) {
        this.publishing = publishing == null ? null : publishing.trim();
    }

  
    public String getCypublished() {
        return cypublished;
    }

    
    public void setCypublished(String cypublished) {
        this.cypublished = cypublished == null ? null : cypublished.trim();
    }

    public String getVerified() {
        return verified;
    }
    public void setVerified(String verified) {
        this.verified = verified == null ? null : verified.trim();
    }

    public String getAgencycertification() {
        return agencycertification;
    }
 
    public void setAgencycertification(String agencycertification) {
        this.agencycertification = agencycertification == null ? null : agencycertification.trim();
    }
 
    public String getCreditlevel() {
        return creditlevel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column userinfo.creditlevel
     *
     * @param creditlevel the value for userinfo.creditlevel
     *
     * @mbggenerated
     */
    public void setCreditlevel(String creditlevel) {
        this.creditlevel = creditlevel == null ? null : creditlevel.trim();
    }

	public String getIsBest() {
		return isBest;
	}

	public void setIsBest(String isBest) {
		this.isBest = isBest;
	}

	public List<TraProduct> getProductions() {
		return productions;
	}

	public void setProductions(List<TraProduct> productions) {
		this.productions = productions;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public String getUsertype() {
		return usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

	public String getSc() {
		return sc;
	}

	public void setSc(String sc) {
		this.sc = sc;
	}

	public String getPpc() {
		return ppc;
	}

	public void setPpc(String ppc) {
		this.ppc = ppc;
	}

	public String getCjc() {
		return cjc;
	}

	public void setCjc(String cjc) {
		this.cjc = cjc;
	}
    
    
}
