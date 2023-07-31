package nccloud.web.wsh.gxbg.gxbgmaster.action;
import java.util.HashMap;
import java.util.Map;
import nccloud.web.codeplatform.framework.action.base.BaseAction;
import nccloud.web.codeplatform.framework.action.base.RequstParamWapper;
import nccloud.web.codeplatform.framework.action.base.RequestDTO;
import nccloud.web.codeplatform.framework.action.base.VOTransform;
import nccloud.framework.service.ServiceLocator;
import nccloud.framework.web.container.IRequest;
import nc.vo.gxbg.gxbg.AggGxbgMasterVO;
import nc.itf.wsh.gxbg.gxbgmaster.IGxbgMasterVOService;


/**
 * ����Action
 */
public class AddGxbgMasterVOAction extends BaseAction{

	@Override
	public Object doAction(IRequest request, RequstParamWapper paramWapper) throws Throwable{
		//json����ת��
		RequestDTO param = VOTransform.toVO(paramWapper.requestString,RequestDTO.class);
		//��ȡ����
		Map<String,Object> userJson = param.getUserJson();

		AggGxbgMasterVO[] vos = this.getVOs(param, AggGxbgMasterVO.class);
		
		//���ʵ��VO
		IGxbgMasterVOService service = ServiceLocator.find(IGxbgMasterVOService.class);
		AggGxbgMasterVO vo = service.preAddAggGxbgMasterVO(vos[0],userJson);
		return buildResult(param,true,null,vo);
		
	}

}