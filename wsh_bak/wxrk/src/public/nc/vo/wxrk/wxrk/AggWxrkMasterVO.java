package nc.vo.wxrk.wxrk;

import nc.vo.pubapp.pattern.model.entity.bill.AbstractBill;
import nc.vo.pubapp.pattern.model.meta.entity.bill.BillMetaFactory;
import nc.vo.pubapp.pattern.model.meta.entity.bill.IBillMeta;
import nc.vo.wxrk.wxrk.WxrkMasterVO;

/**
 * 
 * ���ӱ�/����ͷ/������ۺ�VO
 *
 * ��������:
 * @author 
 * @version NCPrj ??
 */
@nc.vo.annotation.AggVoInfo(parentVO = "nc.vo.wxrk.wxrk.WxrkMasterVO")
public class  AggWxrkMasterVO  extends AbstractBill {
	
	private static final long serialVersionUID = 1309613813878961316L;

      @Override
	  public IBillMeta getMetaData() {
	  	IBillMeta billMeta =BillMetaFactory.getInstance().getBillMeta(AggWxrkMasterVOMeta.class);
	  	return billMeta;
	  }
	    
	  @Override
	  public WxrkMasterVO getParentVO(){
	  	return (WxrkMasterVO)this.getParent();
	  }

      @Override
        public String getPrimaryKey() {
            return super.getPrimaryKey();
      }

}
