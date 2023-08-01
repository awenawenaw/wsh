package nccloud.web.wsh.qcysdgxwx.qcysdgxwxmaster.action;
import nccloud.commons.lang.StringUtils;
import nccloud.web.codeplatform.framework.action.base.BaseAction;
import nccloud.web.codeplatform.framework.action.base.RequstParamWapper;
import nccloud.web.codeplatform.framework.action.base.VOTransform;
import nccloud.web.codeplatform.framework.action.base.RequestDTO;
import nccloud.framework.service.ServiceLocator;
import nccloud.framework.web.container.IRequest;
import nccloud.framework.core.exception.BusinessException;
import nc.vo.qcysdgxwx.qcysdgxwx.AggQcysdgxwxMasterVO;
import nc.itf.wsh.qcysdgxwx.qcysdgxwxmaster.IQcysdgxwxMasterVOService;
/**
 * ��Ƭ��ѯ
 */
public class LoadQcysdgxwxMasterVOAction extends BaseAction{

	@Override
	public Object doAction(IRequest request, RequstParamWapper paramWapper) throws Throwable{
		RequestDTO param = VOTransform.toVO(paramWapper.requestString,RequestDTO.class);
		
		String pk = param.getPk();
		if(StringUtils.isEmpty(pk)){
			throw new BusinessException("������ȱ��pk������������룡");
		}
		IQcysdgxwxMasterVOService service = ServiceLocator.find(IQcysdgxwxMasterVOService.class);
		
		AggQcysdgxwxMasterVO vo = service.findAggQcysdgxwxMasterVOByPk(pk);
		if(vo == null){
			return null;
		}
		
		return buildResult(param,true,null,vo);
	}
	
}