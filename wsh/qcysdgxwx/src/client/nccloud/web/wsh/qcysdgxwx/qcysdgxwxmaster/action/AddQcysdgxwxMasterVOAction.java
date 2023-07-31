package nccloud.web.wsh.qcysdgxwx.qcysdgxwxmaster.action;
import java.util.HashMap;
import java.util.Map;
import nccloud.web.codeplatform.framework.action.base.BaseAction;
import nccloud.web.codeplatform.framework.action.base.RequstParamWapper;
import nccloud.web.codeplatform.framework.action.base.RequestDTO;
import nccloud.web.codeplatform.framework.action.base.VOTransform;
import nccloud.framework.service.ServiceLocator;
import nccloud.framework.web.container.IRequest;
import nc.vo.qcysdgxwx.qcysdgxwx.AggQcysdgxwxMasterVO;
import nc.itf.wsh.qcysdgxwx.qcysdgxwxmaster.IQcysdgxwxMasterVOService;


/**
 * ����Action
 */
public class AddQcysdgxwxMasterVOAction extends BaseAction{

	@Override
	public Object doAction(IRequest request, RequstParamWapper paramWapper) throws Throwable{
		//json����ת��
		RequestDTO param = VOTransform.toVO(paramWapper.requestString,RequestDTO.class);
		//��ȡ����
		Map<String,Object> userJson = param.getUserJson();

		AggQcysdgxwxMasterVO[] vos = this.getVOs(param, AggQcysdgxwxMasterVO.class);
		
		//���ʵ��VO
		IQcysdgxwxMasterVOService service = ServiceLocator.find(IQcysdgxwxMasterVOService.class);
		AggQcysdgxwxMasterVO vo = service.preAddAggQcysdgxwxMasterVO(vos[0],userJson);
		return buildResult(param,true,null,vo);
		
	}

}