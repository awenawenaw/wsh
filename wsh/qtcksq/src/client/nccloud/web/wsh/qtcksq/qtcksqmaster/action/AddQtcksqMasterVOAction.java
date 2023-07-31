package nccloud.web.wsh.qtcksq.qtcksqmaster.action;
import java.util.HashMap;
import java.util.Map;
import nccloud.web.codeplatform.framework.action.base.BaseAction;
import nccloud.web.codeplatform.framework.action.base.RequstParamWapper;
import nccloud.web.codeplatform.framework.action.base.RequestDTO;
import nccloud.web.codeplatform.framework.action.base.VOTransform;
import nccloud.framework.service.ServiceLocator;
import nccloud.framework.web.container.IRequest;
import nc.vo.qtcksq.qtcksq.AggQtcksqMasterVO;
import nc.itf.wsh.qtcksq.qtcksqmaster.IQtcksqMasterVOService;


/**
 * ����Action
 */
public class AddQtcksqMasterVOAction extends BaseAction{

	@Override
	public Object doAction(IRequest request, RequstParamWapper paramWapper) throws Throwable{
		//json����ת��
		RequestDTO param = VOTransform.toVO(paramWapper.requestString,RequestDTO.class);
		//��ȡ����
		Map<String,Object> userJson = param.getUserJson();

		AggQtcksqMasterVO[] vos = this.getVOs(param, AggQtcksqMasterVO.class);
		
		//���ʵ��VO
		IQtcksqMasterVOService service = ServiceLocator.find(IQtcksqMasterVOService.class);
		AggQtcksqMasterVO vo = service.preAddAggQtcksqMasterVO(vos[0],userJson);
		return buildResult(param,true,null,vo);
		
	}

}