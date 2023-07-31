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
 * �༭Action
 */
public class EditClqrMasterVOAction extends BaseAction{
	@Override
	public Object doAction(IRequest request, RequstParamWapper paramWapper) throws Throwable{
		//json����ת��
		RequestDTO param = VOTransform.toVO(paramWapper.requestString,RequestDTO.class);
		//��ȡ����
		String pk = param.getPk();
		
		IClqrMasterVOService service = ServiceLocator.find(IClqrMasterVOService.class);
		
		AggClqrMasterVO vo = service.preEditAggClqrMasterVO(pk);
		
		if(vo == null){
			return null;
		}
		return buildResult(param,true,null,vo);
	}
	
}