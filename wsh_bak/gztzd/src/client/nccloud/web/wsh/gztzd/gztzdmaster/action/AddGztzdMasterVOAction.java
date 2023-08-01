package nccloud.web.wsh.gztzd.gztzdmaster.action;
import java.util.HashMap;
import java.util.Map;
import nccloud.web.codeplatform.framework.action.base.BaseAction;
import nccloud.web.codeplatform.framework.action.base.RequstParamWapper;
import nccloud.web.codeplatform.framework.action.base.RequestDTO;
import nccloud.web.codeplatform.framework.action.base.VOTransform;
import nccloud.framework.service.ServiceLocator;
import nccloud.framework.web.container.IRequest;
import nc.vo.gztzd.gztzd.AggGztzdMasterVO;
import nc.itf.wsh.gztzd.gztzdmaster.IGztzdMasterVOService;


/**
 * ����Action
 */
public class AddGztzdMasterVOAction extends BaseAction{

	@Override
	public Object doAction(IRequest request, RequstParamWapper paramWapper) throws Throwable{
		//json����ת��
		RequestDTO param = VOTransform.toVO(paramWapper.requestString,RequestDTO.class);
		//��ȡ����
		Map<String,Object> userJson = param.getUserJson();

		AggGztzdMasterVO[] vos = this.getVOs(param, AggGztzdMasterVO.class);
		
		//���ʵ��VO
		IGztzdMasterVOService service = ServiceLocator.find(IGztzdMasterVOService.class);
		AggGztzdMasterVO vo = service.preAddAggGztzdMasterVO(vos[0],userJson);
		return buildResult(param,true,null,vo);
		
	}

}