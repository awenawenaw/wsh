package nccloud.web.wsh.wxrk.wxrkmaster.action;

import java.util.Map;
import nccloud.web.codeplatform.framework.action.base.BaseAction;
import nccloud.web.codeplatform.framework.action.base.RequstParamWapper;
import nccloud.web.codeplatform.framework.action.base.RequestDTO;
import nccloud.web.codeplatform.framework.action.base.VOTransform;
import nccloud.framework.service.ServiceLocator;
import nccloud.framework.web.container.IRequest;
import nccloud.base.exception.BusinessException;
import nc.itf.wsh.wxrk.wxrkmaster.IWxrkMasterVOService;
/**
 * 删除Action
 */
public class DeleteWxrkMasterVOAction extends BaseAction{

	@Override
	public Object doAction(IRequest request, RequstParamWapper paramWapper) throws Throwable{
		RequestDTO param = VOTransform.toVO(paramWapper.requestString,RequestDTO.class);
		Map<String,String> tsMap = param.getTsMap();
		
		if(tsMap == null || tsMap.size() == 0){
			throw new BusinessException("通过getTsMap()获取pk与ts组成的Map集合作为参数时未获取到，请传递tsMap");
		}
		
		IWxrkMasterVOService service = ServiceLocator.find(IWxrkMasterVOService.class);
		service.deleteAggWxrkMasterVOs(tsMap);
		return true;
	}
	
}