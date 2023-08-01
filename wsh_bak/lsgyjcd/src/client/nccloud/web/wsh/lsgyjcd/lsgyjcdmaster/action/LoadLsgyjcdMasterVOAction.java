package nccloud.web.wsh.lsgyjcd.lsgyjcdmaster.action;
import nccloud.commons.lang.StringUtils;
import nccloud.web.codeplatform.framework.action.base.BaseAction;
import nccloud.web.codeplatform.framework.action.base.RequstParamWapper;
import nccloud.web.codeplatform.framework.action.base.VOTransform;
import nccloud.web.codeplatform.framework.action.base.RequestDTO;
import nccloud.framework.service.ServiceLocator;
import nccloud.framework.web.container.IRequest;
import nccloud.framework.core.exception.BusinessException;
import nc.vo.lsgyjcd.lsgyjcd.AggLsgyjcdMasterVO;
import nc.itf.wsh.lsgyjcd.lsgyjcdmaster.ILsgyjcdMasterVOService;
/**
 * ��Ƭ��ѯ
 */
public class LoadLsgyjcdMasterVOAction extends BaseAction{

	@Override
	public Object doAction(IRequest request, RequstParamWapper paramWapper) throws Throwable{
		RequestDTO param = VOTransform.toVO(paramWapper.requestString,RequestDTO.class);
		
		String pk = param.getPk();
		if(StringUtils.isEmpty(pk)){
			throw new BusinessException("������ȱ��pk������������룡");
		}
		ILsgyjcdMasterVOService service = ServiceLocator.find(ILsgyjcdMasterVOService.class);
		
		AggLsgyjcdMasterVO vo = service.findAggLsgyjcdMasterVOByPk(pk);
		if(vo == null){
			return null;
		}
		
		return buildResult(param,true,null,vo);
	}
	
}