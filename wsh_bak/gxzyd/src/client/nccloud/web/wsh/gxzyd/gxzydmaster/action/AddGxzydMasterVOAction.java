package nccloud.web.wsh.gxzyd.gxzydmaster.action;
import java.util.HashMap;
import java.util.Map;
import nccloud.web.codeplatform.framework.action.base.BaseAction;
import nccloud.web.codeplatform.framework.action.base.RequstParamWapper;
import nccloud.web.codeplatform.framework.action.base.RequestDTO;
import nccloud.web.codeplatform.framework.action.base.VOTransform;
import nccloud.framework.service.ServiceLocator;
import nccloud.framework.web.container.IRequest;
import nc.vo.gxzyd.gxzyd.AggGxzydMasterVO;
import nc.itf.wsh.gxzyd.gxzydmaster.IGxzydMasterVOService;


/**
 * ����Action
 */
public class AddGxzydMasterVOAction extends BaseAction{

	@Override
	public Object doAction(IRequest request, RequstParamWapper paramWapper) throws Throwable{
		//json����ת��
		RequestDTO param = VOTransform.toVO(paramWapper.requestString,RequestDTO.class);
		//��ȡ����
		Map<String,Object> userJson = param.getUserJson();

		AggGxzydMasterVO[] vos = this.getVOs(param, AggGxzydMasterVO.class);
		
		//���ʵ��VO
		IGxzydMasterVOService service = ServiceLocator.find(IGxzydMasterVOService.class);
		AggGxzydMasterVO vo = service.preAddAggGxzydMasterVO(vos[0],userJson);
		return buildResult(param,true,null,vo);
		
	}

}