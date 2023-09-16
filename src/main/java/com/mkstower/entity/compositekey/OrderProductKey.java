package com.mkstower.entity.compositekey;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import jakarta.persistence.*;
import lombok.*;

@Component
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
	Long orderId;
	@Column( name = "product_id" )
	Long productId;	

}
