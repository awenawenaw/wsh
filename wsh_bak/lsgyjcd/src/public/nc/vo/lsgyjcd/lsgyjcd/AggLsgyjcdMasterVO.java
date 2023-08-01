package nc.vo.lsgyjcd.lsgyjcd;

import nc.vo.pubapp.pattern.model.entity.bill.AbstractBill;
import nc.vo.pubapp.pattern.model.meta.entity.bill.BillMetaFactory;
import nc.vo.pubapp.pattern.model.meta.entity.bill.IBillMeta;
import nc.vo.lsgyjcd.lsgyjcd.LsgyjcdMasterVO;

/**
 * 
 * ���ӱ�/����ͷ/������ۺ�VO
 *
 * ��������:
 * @author 
 * @version NCPrj ??
 */
@nc.vo.annotation.AggVoInfo(parentVO = "nc.vo.lsgyjcd.lsgyjcd.LsgyjcdMasterVO")
public class  AggLsgyjcdMasterVO  extends AbstractBill {
	
	private static final long serialVersionUID = 1309613813878961316L;

      @Override
	  public IBillMeta getMetaData() {
	  	IBillMeta billMeta =BillMetaFactory.getInstance().getBillMeta(AggLsgyjcdMasterVOMeta.class);
	  	return billMeta;
	  }
	    
	  @Override
	  public LsgyjcdMasterVO getParentVO(){
	  	return (LsgyjcdMasterVO)this.getParent();
	  }

      @Override
        public String getPrimaryKey() {
            return super.getPrimaryKey();
      }

}
