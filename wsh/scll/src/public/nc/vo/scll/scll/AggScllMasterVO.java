package nc.vo.scll.scll;

import nc.vo.pubapp.pattern.model.entity.bill.AbstractBill;
import nc.vo.pubapp.pattern.model.meta.entity.bill.BillMetaFactory;
import nc.vo.pubapp.pattern.model.meta.entity.bill.IBillMeta;
import nc.vo.scll.scll.ScllMasterVO;

/**
 * 
 * ���ӱ�/����ͷ/������ۺ�VO
 *
 * ��������:
 * @author 
 * @version NCPrj ??
 */
@nc.vo.annotation.AggVoInfo(parentVO = "nc.vo.scll.scll.ScllMasterVO")
public class  AggScllMasterVO  extends AbstractBill {
	
	private static final long serialVersionUID = 1309613813878961316L;

      @Override
	  public IBillMeta getMetaData() {
	  	IBillMeta billMeta =BillMetaFactory.getInstance().getBillMeta(AggScllMasterVOMeta.class);
	  	return billMeta;
	  }
	    
	  @Override
	  public ScllMasterVO getParentVO(){
	  	return (ScllMasterVO)this.getParent();
	  }

      @Override
        public String getPrimaryKey() {
            return super.getPrimaryKey();
      }

}
