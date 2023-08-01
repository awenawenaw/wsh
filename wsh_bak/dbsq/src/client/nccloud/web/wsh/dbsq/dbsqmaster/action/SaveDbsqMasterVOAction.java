package nccloud.web.wsh.dbsq.dbsqmaster.action;

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
import nc.itf.wsh.dbsq.dbsqmaster.IDbsqMasterVOService;
import nc.vo.dbsq.dbsq.AggDbsqMasterVO;

/**
 * ����action�����ӡ�������form��
 */
public class SaveDbsqMasterVOAction extends BaseAction{

	@Override
	public Object doAction(IRequest request, RequstParamWapper paramWapper) throws Throwable{
		RequestDTO param = VOTransform.toVO(paramWapper.requestString,RequestDTO.class);
		
		IDbsqMasterVOService service = ServiceLocator.find(IDbsqMasterVOService.class);

		AggDbsqMasterVO[] vos = this.getVOs(param, AggDbsqMasterVO.class);
		
		vos = service.saveAggDbsqMasterVO(vos[0]);
		Object result = buildResult(param,param.getBillCard().getHead()!=null,null,vos);
		return result;
	
	}
	
}