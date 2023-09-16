package com.mkstower.entity.compositekey;

import java.io.Serializable;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Embeddable
public class OrderProductKey implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column( name = "order_id" )
	long orderId;
	@Column( name = "product_id" )
	long productId;	

}
