package com.neusoft.po;
//退款
public class Refund {
	int oid;				//订单id
	String refundReason;	//退款理由
	String refundTime;		//退款时间
	String status;			//退款状态：待处理、已处理
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public String getRefundReason() {
		return refundReason;
	}
	public void setRefundReason(String refundReason) {
		this.refundReason = refundReason;
	}
	public String getRefundTime() {
		return refundTime;
	}
	public void setRefundTime(String refundTime) {
		this.refundTime = refundTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
