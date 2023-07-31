package nccloud.web.wsh.dbrkd.dbrkdmaster.action;

import java.util.HashMap;
//import java.util.List;
import java.util.Map;
//import nccloud.framework.web.ui.pattern.grid.Grid;
import nccloud.web.codeplatform.framework.action.base.BaseAction;
import nccloud.web.codeplatform.framework.action.base.RequstParamWapper;
import nccloud.web.codeplatform.framework.action.base.RequestDTO;
import nccloud.web.codeplatform.framework.action.base.VOTransform;
import nccloud.framework.service.ServiceLocator;
import nccloud.framework.core.util.ArrayUtils;
import nccloud.framework.web.container.IRequest;
import nc.itf.wsh.dbrkd.dbrkdmaster.IDbrkdMasterVOService;
import nc.vo.dbrkd.dbrkd.AggDbrkdMasterVO;

/**
 * ����action�����ӡ�������form��
 */
public class SaveDbrkdMasterVOAction extends BaseAction{

	@Override
	public Object doAction(IRequest request, RequstParamWapper paramWapper) throws Throwable{
		RequestDTO param = VOTransform.toVO(paramWapper.requestString,RequestDTO.class);
		
		IDbrkdMasterVOService service = ServiceLocator.find(IDbrkdMasterVOService.class);

		AggDbrkdMasterVO[] vos = this.getVOs(param, AggDbrkdMasterVO.class);
		
		vos = service.saveAggDbrkdMasterVO(vos[0]);
		Object result = buildResult(param,param.getBillCard().getHead()!=null,null,vos);
		return result;
	
	}
	
}