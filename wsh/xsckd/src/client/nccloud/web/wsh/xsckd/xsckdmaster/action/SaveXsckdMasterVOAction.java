package nccloud.web.wsh.xsckd.xsckdmaster.action;

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
import nc.itf.wsh.xsckd.xsckdmaster.IXsckdMasterVOService;
import nc.vo.wsh.xsckd.AggXsckdMasterVO;

/**
 * 保存action（主子、单表、单form）
 */
public class SaveXsckdMasterVOAction extends BaseAction{

	@Override
	public Object doAction(IRequest request, RequstParamWapper paramWapper) throws Throwable{
		RequestDTO param = VOTransform.toVO(paramWapper.requestString,RequestDTO.class);
		
		IXsckdMasterVOService service = ServiceLocator.find(IXsckdMasterVOService.class);

		AggXsckdMasterVO[] vos = this.getVOs(param, AggXsckdMasterVO.class);
		
		vos = service.saveAggXsckdMasterVO(vos[0]);
		Object result = buildResult(param,param.getBillCard().getHead()!=null,null,vos);
		return result;
	
	}
	
}