package nccloud.web.wsh.hwtzd.hwtzdmaster.action;
import java.util.HashMap;
import java.util.Map;
import nccloud.web.codeplatform.framework.action.base.BaseAction;
import nccloud.web.codeplatform.framework.action.base.RequstParamWapper;
import nccloud.web.codeplatform.framework.action.base.RequestDTO;
import nccloud.web.codeplatform.framework.action.base.VOTransform;
import nccloud.framework.service.ServiceLocator;
import nccloud.framework.web.container.IRequest;
import nc.vo.hwtzd.hwtzd.AggHwtzdMasterVO;
import nc.itf.wsh.hwtzd.hwtzdmaster.IHwtzdMasterVOService;


/**
 * ����Action
 */
public class AddHwtzdMasterVOAction extends BaseAction{

	@Override
	public Object doAction(IRequest request, RequstParamWapper paramWapper) throws Throwable{
		//json����ת��
		RequestDTO param = VOTransform.toVO(paramWapper.requestString,RequestDTO.class);
		//��ȡ����
		Map<String,Object> userJson = param.getUserJson();

		AggHwtzdMasterVO[] vos = this.getVOs(param, AggHwtzdMasterVO.class);
		
		//���ʵ��VO
		IHwtzdMasterVOService service = ServiceLocator.find(IHwtzdMasterVOService.class);
		AggHwtzdMasterVO vo = service.preAddAggHwtzdMasterVO(vos[0],userJson);
		return buildResult(param,true,null,vo);
		
	}

}