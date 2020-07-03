package com.job.coverletter.model.supportPay.dto;

import java.util.Date;

public class SupportPayDto {

	private String tid;
	private String cid;
	private String partner_order_id;
	private String joinemail;
	private String payment_method_type;
	//private String amount;
	private String amount_total;
	private String amount_tax_free;
	private String item_name;
	private String quantity;
	private Date created_at;

	private int StartIndex;
	private int CntPerPage;
	// 현재페이지
	private int curPage;

	/*---------- 검색 ----------*/
	private String category;
	private String keyword;
	
	
	public SupportPayDto() {}
	
	public SupportPayDto(String tid, String cid, String partner_order_id, String joinemail,
			String payment_method_type, String amount_total, String amount_tax_free, String item_name, String quantity,
			Date created_at, int startIndex, int cntPerPage, int curPage, String category, String keyword) {
		super();
		this.tid = tid;
		this.cid = cid;
		this.partner_order_id = partner_order_id;
		this.joinemail = joinemail;
		this.payment_method_type = payment_method_type;
		this.amount_total = amount_total;
		this.amount_tax_free = amount_tax_free;
		this.item_name = item_name;
		this.quantity = quantity;
		this.created_at = created_at;
		StartIndex = startIndex;
		CntPerPage = cntPerPage;
		this.curPage = curPage;
		this.category = category;
		this.keyword = keyword;
	}



	public SupportPayDto(String tid, String cid, String partner_order_id, String joinemail,
			String payment_method_type, String amount_total, String amount_tax_free, String item_name,
			String quantity, Date created_at) {
		this.tid = tid;
		this.cid = cid;
		this.partner_order_id = partner_order_id;
		this.joinemail = joinemail;
		this.payment_method_type = payment_method_type;
		//this.amount = amount;
		this.amount_total = amount_total;
		this.amount_tax_free = amount_tax_free;
		this.item_name = item_name;
		this.quantity = quantity;
		this.created_at = created_at;
	}

	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getPartner_order_id() {
		return partner_order_id;
	}

	public void setPartner_order_id(String partner_order_id) {
		this.partner_order_id = partner_order_id;
	}

	public String getjoinemail() {
		return joinemail;
	}

	public void setjoinemail(String joinemail) {
		this.joinemail = joinemail;
	}

	public String getPayment_method_type() {
		return payment_method_type;
	}

	public void setPayment_method_type(String payment_method_type) {
		this.payment_method_type = payment_method_type;
	}

//	public String getAmount() {
//		return amount;
//	}
//
//	public void setAmount(String amount) {
//		this.amount = amount;
//	}

	public String getAmount_total() {
		return amount_total;
	}

	public void setAmount_total(String amount_total) {
		this.amount_total = amount_total;
	}

	public String getAmount_tax_free() {
		return amount_tax_free;
	}

	public void setAmount_tax_free(String amount_tax_free) {
		this.amount_tax_free = amount_tax_free;
	}

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public int getStartIndex() {
		return StartIndex;
	}

	public void setStartIndex(int startIndex) {
		StartIndex = startIndex;
	}

	public int getCntPerPage() {
		return CntPerPage;
	}

	public void setCntPerPage(int cntPerPage) {
		CntPerPage = cntPerPage;
	}

	public int getCurPage() {
		return curPage;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	@Override
	public String toString() {
		return "SupportPayDto [tid=" + tid + ", cid=" + cid + ", partner_order_id=" + partner_order_id
				+ ", joinemail=" + joinemail + ", payment_method_type=" + payment_method_type
				+ ", amount_total=" + amount_total + ", amount_tax_free=" + amount_tax_free + ", item_name=" + item_name
				+ ", quantity=" + quantity + ", created_at=" + created_at + "]";
	}

	
	
	
	
	
}
