package nc.vo.qtcksq.qtcksq;

import nc.vo.pubapp.pattern.model.meta.entity.bill.AbstractBillMeta;

public class AggQtcksqMasterVOMeta  extends AbstractBillMeta{
	
	public AggQtcksqMasterVOMeta(){
		this.init();
	}

    private void init() {
        this.setParent(nc.vo.qtcksq.qtcksq.QtcksqMasterVO.class);
            this.addChildren(nc.vo.qtcksq.qtcksq.QtcksqSlave0VO.class);
    }

}
