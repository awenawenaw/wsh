package nccloud.web.wsh.clqr.clqrmaster.action;
import java.util.HashMap;
import java.util.Map;
import nccloud.web.codeplatform.framework.action.base.BaseAction;
import nccloud.web.codeplatform.framework.action.base.RequstParamWapper;
import nccloud.web.codeplatform.framework.action.base.RequestDTO;
import nccloud.web.codeplatform.framework.action.base.VOTransform;
import nccloud.framework.service.ServiceLocator;
import nccloud.framework.web.container.IRequest;
import nc.vo.clqr.clqr.AggClqrMasterVO;
import nc.itf.wsh.clqr.clqrmaster.IClqrMasterVOService;


/**
 * ����Action
 */
public class AddClqrMasterVOAction extends BaseAction{

	@Override
	public Object doAction(IRequest request, RequstParamWapper paramWapper) throws Throwable{
		//json����ת��
		RequestDTO param = VOTransform.toVO(paramWapper.requestString,RequestDTO.class);
		//��ȡ����
		Map<String,Object> userJson = param.getUserJson();

		AggClqrMasterVO[] vos = this.getVOs(param, AggClqrMasterVO.class);
		
		//���ʵ��VO
		IClqrMasterVOService service = ServiceLocator.find(IClqrMasterVOService.class);
		AggClqrMasterVO vo = service.preAddAggClqrMasterVO(vos[0],userJson);
		return buildResult(param,true,null,vo);
		
	}

}