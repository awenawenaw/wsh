package nccloud.web.wsh.qtckqr.qtckqrmaster.action;
import java.util.HashMap;
import java.util.Map;
import nccloud.web.codeplatform.framework.action.base.BaseAction;
import nccloud.web.codeplatform.framework.action.base.RequstParamWapper;
import nccloud.web.codeplatform.framework.action.base.RequestDTO;
import nccloud.web.codeplatform.framework.action.base.VOTransform;
import nccloud.framework.service.ServiceLocator;
import nccloud.framework.web.container.IRequest;
import nc.vo.qtckqr.qtckqr.AggQtckqrMasterVO;
import nc.itf.wsh.qtckqr.qtckqrmaster.IQtckqrMasterVOService;


/**
 * ����Action
 */
public class AddQtckqrMasterVOAction extends BaseAction{

	@Override
	public Object doAction(IRequest request, RequstParamWapper paramWapper) throws Throwable{
		//json����ת��
		RequestDTO param = VOTransform.toVO(paramWapper.requestString,RequestDTO.class);
		//��ȡ����
		Map<String,Object> userJson = param.getUserJson();

		AggQtckqrMasterVO[] vos = this.getVOs(param, AggQtckqrMasterVO.class);
		
		//���ʵ��VO
		IQtckqrMasterVOService service = ServiceLocator.find(IQtckqrMasterVOService.class);
		AggQtckqrMasterVO vo = service.preAddAggQtckqrMasterVO(vos[0],userJson);
		return buildResult(param,true,null,vo);
		
	}

}