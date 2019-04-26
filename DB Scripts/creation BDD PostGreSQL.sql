
CREATE TABLE public.departement (
                code VARCHAR NOT NULL,
                nom VARCHAR NOT NULL,
                CONSTRAINT departement_pk PRIMARY KEY (code)
);


CREATE SEQUENCE public.ville_ville_id_seq;

CREATE TABLE public.ville (
                ville_id INTEGER NOT NULL DEFAULT nextval('public.ville_ville_id_seq'),
                nom VARCHAR NOT NULL,
                code_departement VARCHAR NOT NULL,
                CONSTRAINT ville_pk PRIMARY KEY (ville_id)
);


ALTER SEQUENCE public.ville_ville_id_seq OWNED BY public.ville.ville_id;

CREATE SEQUENCE public.utilisateur_utilisateur_id_seq;

CREATE TABLE public.utilisateur (
                utilisateur_id INTEGER NOT NULL DEFAULT nextval('public.utilisateur_utilisateur_id_seq'),
                pseudo VARCHAR NOT NULL,
                mail VARCHAR NOT NULL,
                mot_de_passe VARCHAR NOT NULL,
                role VARCHAR NOT NULL,
                enabled BOOLEAN NOT NULL,
                CONSTRAINT utilisateur_pk PRIMARY KEY (utilisateur_id)
);


ALTER SEQUENCE public.utilisateur_utilisateur_id_seq OWNED BY public.utilisateur.utilisateur_id;

CREATE SEQUENCE public.topo_topo_id_seq;

CREATE TABLE public.topo (
                topo_id INTEGER NOT NULL DEFAULT nextval('public.topo_topo_id_seq'),
                nom VARCHAR NOT NULL,
                description TEXT NOT NULL,
                CONSTRAINT topo_pk PRIMARY KEY (topo_id)
);


ALTER SEQUENCE public.topo_topo_id_seq OWNED BY public.topo.topo_id;

CREATE SEQUENCE public.utilisateur_topos_utilisateur_topos_id_seq;

CREATE TABLE public.utilisateur_topos (
                utilisateur_topos_id INTEGER NOT NULL DEFAULT nextval('public.utilisateur_topos_utilisateur_topos_id_seq'),
                disponible BOOLEAN NOT NULL,
                utilisateur_emprunteur_id INTEGER,
                date_retour DATE,
                topo_id INTEGER NOT NULL,
                utilisateur_id INTEGER NOT NULL,
                CONSTRAINT utilisateur_topos_pk PRIMARY KEY (utilisateur_topos_id)
);


ALTER SEQUENCE public.utilisateur_topos_utilisateur_topos_id_seq OWNED BY public.utilisateur_topos.utilisateur_topos_id;

CREATE SEQUENCE public.site_site_id_seq;

CREATE TABLE public.site (
                site_id INTEGER NOT NULL DEFAULT nextval('public.site_site_id_seq'),
                nom VARCHAR NOT NULL,
                ville_id INTEGER NOT NULL,
                code_departement VARCHAR NOT NULL,
                CONSTRAINT site_pk PRIMARY KEY (site_id)
);


ALTER SEQUENCE public.site_site_id_seq OWNED BY public.site.site_id;

CREATE TABLE public.topo_sites (
                topo_id INTEGER NOT NULL,
                site_id INTEGER NOT NULL,
                CONSTRAINT topo_sites_pk PRIMARY KEY (topo_id, site_id)
);


CREATE SEQUENCE public.secteur_secteur_id_seq;

CREATE TABLE public.secteur (
                secteur_id INTEGER NOT NULL DEFAULT nextval('public.secteur_secteur_id_seq'),
                nom VARCHAR NOT NULL,
                site_id INTEGER NOT NULL,
                CONSTRAINT secteur_pk PRIMARY KEY (secteur_id)
);


ALTER SEQUENCE public.secteur_secteur_id_seq OWNED BY public.secteur.secteur_id;

CREATE SEQUENCE public.voie_voie_id_seq;

CREATE TABLE public.voie (
                voie_id INTEGER NOT NULL DEFAULT nextval('public.voie_voie_id_seq'),
                nom VARCHAR NOT NULL,
                secteur_id INTEGER NOT NULL,
                CONSTRAINT voie_pk PRIMARY KEY (voie_id)
);


ALTER SEQUENCE public.voie_voie_id_seq OWNED BY public.voie.voie_id;

CREATE SEQUENCE public.commentaire_commentaire_id_seq;

CREATE TABLE public.commentaire (
                commentaire_id INTEGER NOT NULL DEFAULT nextval('public.commentaire_commentaire_id_seq'),
                texte TEXT NOT NULL,
                date TIMESTAMP NOT NULL,
                utilisateur_id INTEGER NOT NULL,
                voie_id INTEGER NOT NULL,
                CONSTRAINT commentaire_pk PRIMARY KEY (commentaire_id)
);


ALTER SEQUENCE public.commentaire_commentaire_id_seq OWNED BY public.commentaire.commentaire_id;

CREATE SEQUENCE public.longueur_longueur_id_seq;

CREATE TABLE public.longueur (
                longueur_id INTEGER NOT NULL DEFAULT nextval('public.longueur_longueur_id_seq'),
                description TEXT NOT NULL,
                cotation VARCHAR NOT NULL,
                numero INTEGER NOT NULL,
                hauteur INTEGER NOT NULL,
                nombre_points INTEGER NOT NULL,
                voie_id INTEGER NOT NULL,
                CONSTRAINT longueur_pk PRIMARY KEY (longueur_id)
);


ALTER SEQUENCE public.longueur_longueur_id_seq OWNED BY public.longueur.longueur_id;

ALTER TABLE public.ville ADD CONSTRAINT departement_ville_fk
FOREIGN KEY (code_departement)
REFERENCES public.departement (code)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.site ADD CONSTRAINT departement_site_fk
FOREIGN KEY (code_departement)
REFERENCES public.departement (code)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.site ADD CONSTRAINT ville_site_fk
FOREIGN KEY (ville_id)
REFERENCES public.ville (ville_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.utilisateur_topos ADD CONSTRAINT utilisateur_utilisateur_topos_fk1
FOREIGN KEY (utilisateur_emprunteur_id)
REFERENCES public.utilisateur (utilisateur_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.commentaire ADD CONSTRAINT utilisateur_commentaire_fk
FOREIGN KEY (utilisateur_id)
REFERENCES public.utilisateur (utilisateur_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.utilisateur_topos ADD CONSTRAINT utilisateur_utilisateur_topos_fk
FOREIGN KEY (utilisateur_id)
REFERENCES public.utilisateur (utilisateur_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.topo_sites ADD CONSTRAINT topo_topo_sites_fk
FOREIGN KEY (topo_id)
REFERENCES public.topo (topo_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.utilisateur_topos ADD CONSTRAINT topo_utilisateur_topos_fk
FOREIGN KEY (topo_id)
REFERENCES public.topo (topo_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.secteur ADD CONSTRAINT site_secteur_fk
FOREIGN KEY (site_id)
REFERENCES public.site (site_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.topo_sites ADD CONSTRAINT site_topo_sites_fk
FOREIGN KEY (site_id)
REFERENCES public.site (site_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.voie ADD CONSTRAINT secteur_voie_fk
FOREIGN KEY (secteur_id)
REFERENCES public.secteur (secteur_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.longueur ADD CONSTRAINT voie_longueur_fk
FOREIGN KEY (voie_id)
REFERENCES public.voie (voie_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.commentaire ADD CONSTRAINT voie_commentaire_fk
FOREIGN KEY (voie_id)
REFERENCES public.voie (voie_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;
