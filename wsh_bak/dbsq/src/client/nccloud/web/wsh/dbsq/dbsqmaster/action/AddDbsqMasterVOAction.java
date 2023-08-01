package nccloud.web.wsh.dbsq.dbsqmaster.action;
import java.util.HashMap;
import java.util.Map;
import nccloud.web.codeplatform.framework.action.base.BaseAction;
import nccloud.web.codeplatform.framework.action.base.RequstParamWapper;
import nccloud.web.codeplatform.framework.action.base.RequestDTO;
import nccloud.web.codeplatform.framework.action.base.VOTransform;
import nccloud.framework.service.ServiceLocator;
import nccloud.framework.web.container.IRequest;
import nc.vo.dbsq.dbsq.AggDbsqMasterVO;
import nc.itf.wsh.dbsq.dbsqmaster.IDbsqMasterVOService;


/**
 * ����Action
 */
public class AddDbsqMasterVOAction extends BaseAction{

	@Override
	public Object doAction(IRequest request, RequstParamWapper paramWapper) throws Throwable{
		//json����ת��
		RequestDTO param = VOTransform.toVO(paramWapper.requestString,RequestDTO.class);
		//��ȡ����
		Map<String,Object> userJson = param.getUserJson();

		AggDbsqMasterVO[] vos = this.getVOs(param, AggDbsqMasterVO.class);
		
		//���ʵ��VO
		IDbsqMasterVOService service = ServiceLocator.find(IDbsqMasterVOService.class);
		AggDbsqMasterVO vo = service.preAddAggDbsqMasterVO(vos[0],userJson);
		return buildResult(param,true,null,vo);
		
	}

}