package nccloud.web.wsh.qtckqr.qtckqrmaster.action;

import java.util.Map;
import nccloud.web.codeplatform.framework.action.base.BaseAction;
import nccloud.web.codeplatform.framework.action.base.RequstParamWapper;
import nccloud.web.codeplatform.framework.action.base.RequestDTO;
import nccloud.web.codeplatform.framework.action.base.VOTransform;
import nccloud.framework.service.ServiceLocator;
import nccloud.framework.web.container.IRequest;
import nccloud.base.exception.BusinessException;
import nc.itf.wsh.qtckqr.qtckqrmaster.IQtckqrMasterVOService;
/**
 * ɾ��Action
 */
public class DeleteQtckqrMasterVOAction extends BaseAction{

	@Override
	public Object doAction(IRequest request, RequstParamWapper paramWapper) throws Throwable{
		RequestDTO param = VOTransform.toVO(paramWapper.requestString,RequestDTO.class);
		Map<String,String> tsMap = param.getTsMap();
		
		if(tsMap == null || tsMap.size() == 0){
			throw new BusinessException("ͨ��getTsMap()��ȡpk��ts��ɵ�Map������Ϊ����ʱδ��ȡ�����봫��tsMap");
		}
		
		IQtckqrMasterVOService service = ServiceLocator.find(IQtckqrMasterVOService.class);
		service.deleteAggQtckqrMasterVOs(tsMap);
		return true;
	}
	
}