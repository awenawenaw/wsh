package nccloud.web.wsh.lsgyjcd.lsgyjcdmaster.action;
import java.util.HashMap;
import java.util.Map;
import nccloud.web.codeplatform.framework.action.base.BaseAction;
import nccloud.web.codeplatform.framework.action.base.RequstParamWapper;
import nccloud.web.codeplatform.framework.action.base.RequestDTO;
import nccloud.web.codeplatform.framework.action.base.VOTransform;
import nccloud.framework.service.ServiceLocator;
import nccloud.framework.web.container.IRequest;
import nc.vo.lsgyjcd.lsgyjcd.AggLsgyjcdMasterVO;
import nc.itf.wsh.lsgyjcd.lsgyjcdmaster.ILsgyjcdMasterVOService;


/**
 * ����Action
 */
public class AddLsgyjcdMasterVOAction extends BaseAction{

	@Override
	public Object doAction(IRequest request, RequstParamWapper paramWapper) throws Throwable{
		//json����ת��
		RequestDTO param = VOTransform.toVO(paramWapper.requestString,RequestDTO.class);
		//��ȡ����
		Map<String,Object> userJson = param.getUserJson();

		AggLsgyjcdMasterVO[] vos = this.getVOs(param, AggLsgyjcdMasterVO.class);
		
		//���ʵ��VO
		ILsgyjcdMasterVOService service = ServiceLocator.find(ILsgyjcdMasterVOService.class);
		AggLsgyjcdMasterVO vo = service.preAddAggLsgyjcdMasterVO(vos[0],userJson);
		return buildResult(param,true,null,vo);
		
	}

}