package cadenaDeResponsabilidades;

import asistente.ReceptorDeMensaje;

public class Meme implements ReceptorDeMensaje {

	private ReceptorDeMensaje next;

	@Override
	public String escuchar(String msg, String usuario) {

		if (msg.contains("take my money") || msg.contains("takemymoney") || msg.contains("shut up and")
				|| msg.contains("shutupand"))
			return "&meme:take_my_money.jpg";

		if (msg.contains("its a trap") || msg.contains("it's a trap"))
			return "&meme:its_a_trap.jpg";
		if (msg.contains("como lo supo") || msg.contains("komo lo supo") || msg.contains("como lo zupo")
				|| msg.contains("komo lo zupo"))
			return "&meme:komo_lo_zupo.jpg";
		if (msg.contains("not bad"))
			return "&meme:not_bad.jpg";
		if (msg.contains("vamo a calmarno") || msg.contains("vamos a calmarno") || msg.contains("vamo a calmarnos")
				|| msg.contains("vamos a calmarnos"))
			return "&meme:vamo_a_calmarno.jpg";
		if (msg.contains("fuck yea"))
			return "&meme:fuck_yea.jpg";
		if (msg.contains("novio distraido") || msg.contains("novio distraído"))
			return "&meme:novio_distraido.jpg";
		if (msg.contains("cant ") || msg.contains("can't"))
			return "&meme:cant.jpg";
		if (msg.contains("???")||msg.contains("what?"))
			return "&meme:what.jpg";
		if (msg.contains("so simply")||msg.contains("tan simple"))
			return "&meme:not_so_simply.jpg";
		if (msg.contains("simpsons")||msg.contains("simpson"))
			return "&meme:simpsons.jpg";
		if (msg.contains("gente muerta")||msg.contains("veo gente"))
			return "&meme:veo_gente_muerta.jpg";
		if (msg.contains("every where")||msg.contains("everywhere"))
			return "&meme:memes_everywhere.jpg";
		if (msg.contains("aliens"))
			return "&meme:aliens.jpg";
		if (msg.contains("bad luck")||msg.contains("mala suerte"))
			return "&meme:bad_luck_brian.jpg";
		
		
		if(msg.contains("meme"))
			return usuario+" estos son los memes disponibles:\n"
					+ "1)take my money\n"
					+ "2)it's a trap\n"
					+ "3)komo lo zupo\n"
					+ "4)not bad\n"
					+ "5)vamo a calmarno\n"
					+ "6)fuck yea\n"
					+ "7)novio distraido\n"
					+ "8)they can't\n"
					+ "9)???\n"
					+ "10)bad luck brian\n"
					+ "11)it's not so simply\n"
					+ "12)veo gente muerta\n"
					+ "13)los simpsons\n"
					+ "14)aliens\n"
					+ "15)everywhere";
		
		
		return next.escuchar(msg, usuario);
	}

	@Override
	public void setNext(ReceptorDeMensaje sig) {
		this.next = sig;

	}

	@Override
	public ReceptorDeMensaje getNext() {
		// TODO Auto-generated method stub
		return this.next;
	}

}
