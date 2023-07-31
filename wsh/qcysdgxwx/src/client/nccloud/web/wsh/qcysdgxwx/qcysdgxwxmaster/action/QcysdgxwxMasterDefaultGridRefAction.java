
package nccloud.web.wsh.qcysdgxwx.qcysdgxwxmaster.action;

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
public class QcysdgxwxMasterDefaultGridRefAction extends DefaultGridRefAction {
	
	public QcysdgxwxMasterDefaultGridRefAction() {
		super();
		setResourceCode(IOrgResourceCodeConst.ORG);
	}

	@Override
	public RefMeta getRefMeta(RefQueryInfo refQueryInfo) {
		RefMeta refMeta = new RefMeta();		
		setResourceCode(IOrgResourceCodeConst.ORG);
		refMeta.setCodeField("code");
		refMeta.setNameField("");
		
		refMeta.setPkField("pk_qcysdmaster");
		refMeta.setTableName("wsh_qcysdgxwxmaster");
		refMeta.setMutilLangNameRef(true);
		return refMeta;
	}

}
