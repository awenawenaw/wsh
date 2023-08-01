package nccloud.web.wsh.dbckd.dbckdmaster.action;
import java.util.HashMap;
import java.util.Map;
import nccloud.web.codeplatform.framework.action.base.BaseAction;
import nccloud.web.codeplatform.framework.action.base.RequstParamWapper;
import nccloud.web.codeplatform.framework.action.base.RequestDTO;
import nccloud.web.codeplatform.framework.action.base.VOTransform;
import nccloud.framework.service.ServiceLocator;
import nccloud.framework.web.container.IRequest;
import nc.vo.dbckd.dbckd.AggDbckdMasterVO;
import nc.itf.wsh.dbckd.dbckdmaster.IDbckdMasterVOService;


/**
 * ����Action
 */
public class AddDbckdMasterVOAction extends BaseAction{

	@Override
	public Object doAction(IRequest request, RequstParamWapper paramWapper) throws Throwable{
		//json����ת��
		RequestDTO param = VOTransform.toVO(paramWapper.requestString,RequestDTO.class);
		//��ȡ����
		Map<String,Object> userJson = param.getUserJson();

		AggDbckdMasterVO[] vos = this.getVOs(param, AggDbckdMasterVO.class);
		
		//���ʵ��VO
		IDbckdMasterVOService service = ServiceLocator.find(IDbckdMasterVOService.class);
		AggDbckdMasterVO vo = service.preAddAggDbckdMasterVO(vos[0],userJson);
		return buildResult(param,true,null,vo);
		
	}

}