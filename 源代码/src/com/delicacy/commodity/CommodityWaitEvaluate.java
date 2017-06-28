package com.delicacy.commodity;

import java.util.Date;

public class CommodityWaitEvaluate extends Commodity {
	private float count;
	private Date finishTime;
	public float getCount() {
		return count;
	}
	public void setCount(float count) {
		this.count = count;
	}
	public Date getFinishTime() {
		return finishTime;
	}
	public void setFinishTime(Date finishTime) {
		this.finishTime = finishTime;
	}

}
