
package nccloud.web.wsh.zkdwx.zkdwxmaster.action;

import nc.itf.org.IOrgResourceCodeConst;
import nccloud.framework.web.processor.refgrid.RefQueryInfo;
import nccloud.framework.web.ui.meta.RefMeta;
import nccloud.web.refer.DefaultGridRefAction;

/**
 * 
 * Ĭ�ϱ�����
 * 
 * @author zx
 * 
 */
public class ZkdwxMasterDefaultGridRefAction extends DefaultGridRefAction {
	
	public ZkdwxMasterDefaultGridRefAction() {
		super();
		setResourceCode(IOrgResourceCodeConst.ORG);
	}

	@Override
	public RefMeta getRefMeta(RefQueryInfo refQueryInfo) {
		RefMeta refMeta = new RefMeta();		
		setResourceCode(IOrgResourceCodeConst.ORG);
		refMeta.setCodeField("code");
		refMeta.setNameField("");
		
		refMeta.setPkField("pk_zkdwxmaster");
		refMeta.setTableName("wsh_zkdwxmaster");
		refMeta.setMutilLangNameRef(true);
		return refMeta;
	}

}
