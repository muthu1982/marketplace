package com.marketplace.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.marketplace.entity.BidEntity;

public interface BidRepo extends CrudRepository<BidEntity,Integer>{

	@Query(value="select * from bid where bid_amount in (select  min(bid_amount) from bid where project_id=?1) and project_id=?1",nativeQuery=true)
	public BidEntity findLowestBidByProjectId(Integer projectId);
	
}
