
package nccloud.web.wsh.clqr.clqrmaster.action;

import nc.itf.org.IOrgResourceCodeConst;
import nccloud.framework.web.processor.refgrid.RefQueryInfo;
import nccloud.framework.web.ui.meta.RefMeta;
import nccloud.web.refer.DefaultGridRefAction;

/**
 * 
 * Ĭ�ϱ������
 * 
 * @author zx
 * 
 */
public class ClqrMasterDefaultGridRefAction extends DefaultGridRefAction {
	
	public ClqrMasterDefaultGridRefAction() {
		super();
		setResourceCode(IOrgResourceCodeConst.ORG);
	}

	@Override
	public RefMeta getRefMeta(RefQueryInfo refQueryInfo) {
		RefMeta refMeta = new RefMeta();		
		setResourceCode(IOrgResourceCodeConst.ORG);
		refMeta.setCodeField("code");
		refMeta.setNameField("");
		
		refMeta.setPkField("pk_llqrmaster");
		refMeta.setTableName("wsh_clqrmaster");
		refMeta.setMutilLangNameRef(true);
		return refMeta;
	}

}
